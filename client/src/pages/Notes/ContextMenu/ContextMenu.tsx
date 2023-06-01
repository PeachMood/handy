import React, { FC, useEffect } from 'react';

import renameNoteIcon from 'assets/images/renameNoteIcon.svg';
import cloneNoteIcon from 'assets/images/cloneNoteIcon.svg';
import copyNoteIcon from 'assets/images/copyNoteIcon.svg';
import deleteNoteIcon from 'assets/images/deleteNoteIcon.svg';
import { useMenuContext } from 'hooks/context/useMenuContext';
import { usePopupContext } from 'hooks/context/usePopupContext';
import { useNotesApi } from 'hooks/api/useNotesApi';
import { useNotesContext } from 'hooks/context/useNotesContext';

import { MenuItem } from './MenuItem/MenuItem';

import styles from './ContextMenu.module.scss';

export const ContextMenu: FC = () => {
  const menu = useMenuContext();
  const popup = usePopupContext();
  const { setRenamedNote } = useNotesContext();
  const { createNote } = useNotesApi();
  const { addNote, setCurrentNote } = useNotesContext();

  const handleMenuClose = () => {
    menu.setIsOpened(false);
  };

  const handleRenameClick = () => {
    setRenamedNote(menu.note);
  };

  const handleCloneClick = async () => {
    try {
      const clone = { name: `${menu.note.name} copy`, content: menu.note.content };
      const response = await createNote(clone);
      const note = response.data;
      addNote(note);
      setCurrentNote(note);
    } catch (error) {
      console.log(error);
    }
  };

  const handleCopyClick = async () => {
    try {
      await navigator.clipboard.writeText(menu.note.content);
    } catch (error) {
      console.log(error);
    }
  };

  const handleDeleteClick = () => {
    popup.setNote(menu.note);
    popup.setIsOpened(true);
  };

  useEffect(() => {
    document.addEventListener('click', handleMenuClose);
    return () => {
      document.removeEventListener('click', handleMenuClose);
    };
  }, []);

  if (!menu.isOpened) {
    return null;
  }

  return (
    <menu className={styles.menu} style={{ top: menu.position.y, left: menu.position.x }}>
      <MenuItem icon={renameNoteIcon} text="Rename" onClick={handleRenameClick} />
      <MenuItem icon={cloneNoteIcon} text="Clone" onClick={handleCloneClick} />
      <MenuItem icon={copyNoteIcon} text="Copy" onClick={handleCopyClick} />
      <MenuItem icon={deleteNoteIcon} text="Delete" type="delete" onClick={handleDeleteClick} />
    </menu>
  );
};
