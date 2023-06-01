import React from 'react';

import { useNotesContext } from 'hooks/context/useNotesContext';
import { IconButton } from 'components/IconButton/IconButton';

import favouriteNoteIcon from 'assets/images/favouriteNoteIcon.svg';
import sortNotes from 'assets/images/sortNotesIcon.svg';
import { ButtonsList } from '../elements/ButtonsList/ButtonsList';
import { NotesList } from '../elements/NotesList/NotesList';

export const FavouritesContent = () => {
  const { notes } = useNotesContext();

  return (
    <article>
      <ButtonsList>
        <IconButton image={favouriteNoteIcon} />
        <IconButton image={sortNotes} />
      </ButtonsList>
      <NotesList notes={notes} />
    </article>
  );
};
