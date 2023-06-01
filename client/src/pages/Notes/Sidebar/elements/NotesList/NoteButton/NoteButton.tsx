import React, { FC, MouseEvent } from 'react';
import classNames from 'classnames';

import { Note } from 'contexts/NotesContext';
import { useNotesContext } from 'hooks/context/useNotesContext';
import { useMenuContext } from 'hooks/context/useMenuContext';

import styles from './NoteButton.module.scss';

export interface NoteButtonProps extends Styleable {
  note: Note;
}

export const NoteButton: FC<NoteButtonProps> = ({ note, className }) => {
  const { setCurrentNote } = useNotesContext();
  const { setNote, setIsOpened, setPosition } = useMenuContext();
  const buttonStyles = classNames(styles.note, className);

  const handleNoteClick = () => {
    setCurrentNote(note);
  };

  const handleMenuOpen = (event: MouseEvent<HTMLButtonElement>) => {
    event.preventDefault();
    setNote(note);
    setIsOpened(true);
    setPosition({ x: event.pageX, y: event.pageY });
  };

  return (
    <button
      className={buttonStyles}
      onClick={handleNoteClick}
      onContextMenu={handleMenuOpen}
    >
      {note.name}
    </button>
  );
};
