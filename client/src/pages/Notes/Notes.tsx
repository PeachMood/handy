import React, { FC, useEffect, useState } from 'react';

import { useNotesContext } from 'hooks/context/useNotesContext';
import { Editor } from './Editor/Editor';
import { Sidebar } from './Sidebar/Sidebar';

import styles from './Notes.module.scss';
import { ContextMenu } from './ContextMenu/ContextMenu';
import { ConfirmPopup } from './ConfirmPopup/ConfirmPopup';

export const Notes: FC = () => {
  const { currentNote } = useNotesContext();

  return (
    <div className={styles.page}>
      <Sidebar />
      <div className={styles.wrapper}>
        <header className={styles.header} />
        <Editor className={styles.editor} content={currentNote?.content} />
      </div>
      <ContextMenu />
      <ConfirmPopup />
    </div>
  );
};
