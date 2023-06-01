import React, { ChangeEvent, useState } from 'react';

import { Note } from 'contexts/NotesContext';
import { IconInput } from 'components/IconInput/IconInput';
import { useNotesContext } from 'hooks/context/useNotesContext';

import searchIcon from 'assets/images/searchIcon.svg';
import { NotesList } from '../elements/NotesList/NotesList';

export const SearchContent = () => {
  const [searchPattern, setSearchPattern] = useState<string>('');
  const { notes } = useNotesContext();

  const handleSearchInput = (event: ChangeEvent<HTMLInputElement>) => {
    setSearchPattern(event.target.value);
  };

  const filterNotes = (notes: Note[], pattern: string): Note[] => {
    if (searchPattern.length === 0) {
      return [];
    }
    return notes.filter((note) => note.name.toLowerCase().startsWith(pattern));
  };

  const filteredNotes = filterNotes(notes, searchPattern);

  return (
    <article>
      <IconInput image={searchIcon} placeholder="Search" onInput={handleSearchInput} />
      <NotesList notes={filteredNotes} />
    </article>
  );
};
