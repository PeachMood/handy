import React, { FC, useEffect, useState } from 'react';

import { useNotesContext } from 'hooks/context/useNotesContext';
import { Editor } from './Editor/Editor';
import { Sidebar } from './Sidebar/Sidebar';

import styles from './Notes.module.scss';
import { ContextMenu } from './ContextMenu/ContextMenu';
import { ConfirmPopup } from './ConfirmPopup/ConfirmPopup';
import { useNotesApi } from 'hooks/api/useNotesApi';

export const Notes: FC = () => {
  const { currentNote, setCurrentNote, updateNote } = useNotesContext();
  const { getNote, editNote } = useNotesApi();
  const [content] = useState<string>(currentNote?.content);

  const handleChange = async (content: string) => {
    try {
      const note = { ...currentNote, content };
      const response = await editNote(note);
      // updateNote(response.data);
      // setCurrentNote(response.data);
    } catch (error) {
      console.log(error);
    }
  }

  useEffect(() => {
    const sendRequest = async () => {
      try {
        const response = await getNote(currentNote.id);
        updateNote(response.data);
        setCurrentNote(response.data);
      } catch (error) {
        console.log(error);
      }
    }

    const sendRequestInInterval = async () => {
      let interval = setInterval(sendRequest, 10000);
      return () => {
        clearInterval(interval);
      };
    }

    sendRequestInInterval();
  }, []);

  return (
    <div className={styles.page}>
      <Sidebar />
      <div className={styles.wrapper}>
        <header className={styles.header} />
        <Editor className={styles.editor} content={content} onChange={handleChange} />
      </div>
      <ContextMenu />
      <ConfirmPopup />
    </div>
  );
};
