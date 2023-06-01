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

  // const handleChange = (content: string) => {
  //   console.log({ content });
  //   const note = { ...currentNote, content };
  //   setCurrentNote(note);
  // }

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

  const [time, setTime] = React.useState(0);
  useEffect(() => {
    const timer = window.setInterval(() => {
      setTime((prevTime) => prevTime + 1); // <-- Change this line!
    }, 1500);
    return () => {
      window.clearInterval(timer);
    };
  }, []);

  // eslint-disable-next-line react-hooks/exhaustive-deps
  useEffect(() => {
    const sendRequest = async () => {
      try {
        const response = await getNote(currentNote.id);
        updateNote(response.data);
        setCurrentNote(response.data);
      } catch (error) {
        console.log(error);
      }
    };

    sendRequest();

  }, [time]);

  return (
    <div className={styles.page}>
      <Sidebar />
      <div className={styles.wrapper}>
        <header className={styles.header} />
        <Editor className={styles.editor} content={currentNote?.content} onChange={handleChange} />
      </div>
      <ContextMenu />
      <ConfirmPopup />
    </div>
  );
};
