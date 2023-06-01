import React from 'react';

import { IconButton } from 'components/IconButton/IconButton';
import { useNotesContext } from 'hooks/context/useNotesContext';
import { useNotesApi } from 'hooks/api/useNotesApi';

import addNoteIcon from 'assets/images/addNoteIcon.svg';
import addFolderIcon from 'assets/images/addFolderIcon.svg';
import sortNotesIcon from 'assets/images/sortNotesIcon.svg';

import { ButtonsList } from '../elements/ButtonsList/ButtonsList';
import { NotesList } from '../elements/NotesList/NotesList';

export const NotesContent = () => {
  const { createNote } = useNotesApi();
  const { setCurrentNote, notes, addNote } = useNotesContext();

  const handleAddNote = async () => {
    try {
      const template = { name: 'Untitled', content: '# Untitled\nYour new awesome note' };
      const response = await createNote(template);
      const note = response.data;
      addNote(note);
      setCurrentNote(note);
    } catch (error) {
      console.log(error);
    }
  };

  return (
    <article>
      <ButtonsList>
        <IconButton image={addNoteIcon} onClick={handleAddNote} />
        <IconButton image={addFolderIcon} />
        <IconButton image={sortNotesIcon} />
      </ButtonsList>
      <NotesList notes={notes} />
    </article>
  );
};
