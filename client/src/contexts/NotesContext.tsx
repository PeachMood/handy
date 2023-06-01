import React, {
  FC, createContext, useEffect, useMemo, useState,
} from 'react';

import { useNotesApi } from 'hooks/api/useNotesApi';
import { useAuthContext } from 'hooks/context/useAuthContext';

export interface Note {
  id?: number;
  name: string;
  content: string;
  createDate?: Date;
  modificationDate?: Date;
}

interface NotesContext {
  currentNote: Note;
  setCurrentNote: (note: Note) => void;
  renamedNote: Note;
  setRenamedNote: (note: Note) => void;
  notes: Note[];
  addNote: (note: Note) => void;
  updateNote: (note: Note) => void;
  deleteNote: (note: Note) => void
}

export const NotesContext = createContext<NotesContext>(null);

export const NotesProvider: FC = ({ children }) => {
  const [notes, setNotes] = useState<Note[]>([]);
  const [currentNote, setCurrentNote] = useState<Note>(notes[0]);
  const [renamedNote, setRenamedNote] = useState<Note>(null);
  const { isLoggedIn } = useAuthContext();
  const { getNotes } = useNotesApi();

  const addNote = (note: Note) => {
    const updatedNotes = [...notes, note];
    setNotes(updatedNotes);
  };

  const updateNote = (note: Note) => {
    const updatedNotes = notes.map((other) => (note.id === other.id ? note : other));
    setNotes(updatedNotes);
  };

  const deleteNote = (note: Note) => {
    const updatedNotes = notes.filter((other) => note.id !== other.id);
    setNotes(updatedNotes);
  };

  useEffect(() => {
    const getUserNotes = async () => {
      try {
        const response = await getNotes();
        const notes = response.data;
        setNotes(notes);
      } catch (error) {
        console.log(error);
      }
    };

    if (isLoggedIn) {
      getUserNotes();
    }
  }, [isLoggedIn]);

  const value = useMemo(() => ({
    currentNote,
    setCurrentNote,
    renamedNote,
    setRenamedNote,
    notes,
    addNote,
    updateNote,
    deleteNote,
  }), [
    currentNote, setCurrentNote, renamedNote,
    setRenamedNote, notes, addNote, updateNote, deleteNote,
  ]);

  return (
    <NotesContext.Provider value={value}>
      {children}
    </NotesContext.Provider>
  );
};
