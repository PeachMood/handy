import React, {
  ChangeEvent, KeyboardEvent, FC, InputHTMLAttributes, useState,
} from 'react';

import { Note } from 'contexts/NotesContext';
import { Input } from 'components/Input/Input';

import { useNotesApi } from 'hooks/api/useNotesApi';
import { useNotesContext } from 'hooks/context/useNotesContext';
import styles from './NoteInput.module.scss';

interface NoteInputProps extends InputHTMLAttributes<HTMLInputElement> {
  note: Note;
}

export const NoteInput: FC<NoteInputProps> = ({ note }) => {
  const [name, setName] = useState<string>(note.name);
  const { setRenamedNote, updateNote } = useNotesContext();
  const { editNote } = useNotesApi();

  const handleInput = (event: ChangeEvent<HTMLInputElement>) => {
    setName(event.target.value);
  };

  const renameNote = async () => {
    try {
      const renamedNote = { ...note, name };
      const response = await editNote(renamedNote);
      updateNote(response.data);
    } catch (error) {
      console.log(error);
    } finally {
      setRenamedNote(null);
    }
  };

  const handleBlur = async () => renameNote();

  const handleEnterKeydown = async (event: KeyboardEvent<HTMLInputElement>) => {
    if (event.key === 'Enter') {
      renameNote();
    }
  };

  return (
    <Input
      className={styles.input}
      value={name}
      onInput={handleInput}
      onBlur={handleBlur}
      onKeyDown={handleEnterKeydown}
    />
  );
};
