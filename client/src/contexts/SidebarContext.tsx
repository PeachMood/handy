import React, {
  createContext, FC, useMemo, useState,
} from 'react';

export enum Content {
  Notes,
  Search,
  Favourites,
}

interface SidebarContext {
  isOpened: boolean;
  setIsOpened: (setter: (state: boolean) => boolean) => void;
  content: Content;
  setContent: (conent: Content) => void;
}

export const SidebarContext = createContext<SidebarContext>(null);

export const SidebarProvider: FC = ({ children }) => {
  const [isOpened, setIsOpened] = useState<boolean>(true);
  const [content, setContent] = useState<Content>(Content.Notes);

  const value = useMemo(() => ({
    isOpened, setIsOpened, content, setContent,
  }), [isOpened, setIsOpened, content, setContent]);

  return (
    <SidebarContext.Provider value={value}>
      {children}
    </SidebarContext.Provider>
  );
};
