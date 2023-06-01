import React, { FC } from 'react';
import classNames from 'classnames';

import { Note } from 'contexts/NotesContext';
import { List } from 'components/List/List';
import { useNotesContext } from 'hooks/context/useNotesContext';

import { NoteButton } from './NoteButton/NoteButton';
import { NoteInput } from './NoteInput/NoteInput';
import styles from './NotesList.module.scss';

interface NotesListProps {
  notes?: Note[];
}

export const NotesList: FC<NotesListProps> = ({ notes }) => {
  const { renamedNote } = useNotesContext();

  const renderNote = (note: Note) => {
    if (renamedNote?.id === note.id) {
      return <NoteInput key={note.id} note={note} />;
    }
    return <NoteButton key={note.id} note={note} />;
  };

  return (
    <List listStyles={styles.notes} itemStyles={styles.note}>
      {notes?.map(renderNote)}
    </List>
  );
};
