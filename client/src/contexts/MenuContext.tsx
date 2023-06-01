import React, {
  createContext, FC, useMemo, useState,
} from 'react';

import { Note } from 'contexts/NotesContext';

interface Position {
  x: number;
  y: number;
}

interface MenuContext {
  isOpened: boolean;
  setIsOpened: (isOpened: boolean) => void;
  position: Position;
  setPosition: (position: Position) => void;
  note: Note;
  setNote: (note: Note) => void;
}

export const MenuContext = createContext<MenuContext>(null);

export const MenuContextProvider: FC = ({ children }) => {
  const [isOpened, setIsOpened] = useState<boolean>(false);
  const [position, setPosition] = useState<Position>({ x: 0, y: 0 });
  const [note, setNote] = useState<Note>(null);

  const value = useMemo(() => ({
    isOpened, setIsOpened, position, setPosition, note, setNote,
  }), [isOpened, setIsOpened, position, setPosition, note, setNote]);

  return (
    <MenuContext.Provider value={value}>
      {children}
    </MenuContext.Provider>
  );
};
