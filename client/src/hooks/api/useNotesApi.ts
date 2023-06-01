import { AxiosResponse } from 'axios';

import { Note } from 'contexts/NotesContext';

import { useAxiosPrivate } from 'hooks/axios/useAxiosPrivate';

interface NotesApi {
  getNotes: () => Promise<AxiosResponse<Note[]>>;
  getNote: (noteId: number) => Promise<AxiosResponse<Note>>;
  createNote: (note: Note) => Promise<AxiosResponse<Note>>;
  editNote: (note: Note) => Promise<AxiosResponse<Note>>;
  deleteNote: (noteId: number) => Promise<AxiosResponse<void>>;
}

export const useNotesApi = (): NotesApi => {
  const axios = useAxiosPrivate();

  const getNotes = async (): Promise<AxiosResponse<Note[]>> => axios.get('/notes');

  const getNote = async (noteId: number): Promise<AxiosResponse<Note>> => axios.get(`/notes/${noteId}`);

  const createNote = async (note: Note): Promise<AxiosResponse<Note>> => axios.post('/notes', note);

  const editNote = (note: Note): Promise<AxiosResponse<Note>> => axios.put(`/notes/${note.id}`, { name: note.name, content: note.content });

  const deleteNote = (noteId: number): Promise<AxiosResponse<void>> => axios.delete(`/notes/${noteId}`);

  return {
    getNotes, getNote, createNote, editNote, deleteNote,
  };
};
