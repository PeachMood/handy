import React, {
  createContext, FC, useMemo, useState,
} from 'react';

import { Note } from 'contexts/NotesContext';

interface PopupContext {
  isOpened: boolean;
  setIsOpened: (isOpened: boolean) => void;
  note: Note;
  setNote: (note: Note) => void;
}

export const PopupContext = createContext<PopupContext>(null);

export const PopupProvider: FC = ({ children }) => {
  const [isOpened, setIsOpened] = useState<boolean>(false);
  const [note, setNote] = useState<Note>(null);

  const value = useMemo(() => ({
    isOpened, setIsOpened, note, setNote,
  }), [isOpened, setIsOpened, note, setNote]);

  return (
    <PopupContext.Provider value={value}>
      {children}
    </PopupContext.Provider>
  );
};
