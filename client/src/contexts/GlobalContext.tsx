import React, { FC } from 'react';

import { AuthProvider } from 'contexts/AuthContext';
import { NotesProvider } from 'contexts/NotesContext';
import { SidebarProvider } from 'contexts/SidebarContext';
import { MenuContextProvider } from 'contexts/MenuContext';
import { PopupProvider } from 'contexts/PopupContext';

export const GlobalProvider: FC = ({ children }) => (
  <AuthProvider>
    <NotesProvider>
      <SidebarProvider>
        <MenuContextProvider>
          <PopupProvider>
            {children}
          </PopupProvider>
        </MenuContextProvider>
      </SidebarProvider>
    </NotesProvider>
  </AuthProvider>
);
