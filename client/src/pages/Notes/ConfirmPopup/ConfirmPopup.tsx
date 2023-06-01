import React, { FC, FormEvent } from 'react';

import { Popup } from 'components/Popup/Popup';
import { Button } from 'components/Button/Button';
import { usePopupContext } from 'hooks/context/usePopupContext';
import { useNotesContext } from 'hooks/context/useNotesContext';
import { useNotesApi } from 'hooks/api/useNotesApi';

import styles from './Confirm.module.scss';

export const ConfirmPopup: FC = () => {
  const notesApi = useNotesApi();
  const { deleteNote } = useNotesContext();
  const { isOpened, setIsOpened, note } = usePopupContext();

  const handleCloseClick = () => {
    setIsOpened(false);
  };

  const handleDeleteClick = async (event: FormEvent<HTMLFormElement>) => {
    try {
      event.preventDefault();
      await notesApi.deleteNote(note.id);
      deleteNote(note);
    } catch (error) {
      console.log(error);
    } finally {
      setIsOpened(false);
    }
  };

  return (
    <Popup className={styles.popup} isOpened={isOpened} onClose={handleCloseClick}>
      <form onSubmit={handleDeleteClick}>
        <h2 className={styles.title}>Delete a note</h2>
        <p className={styles.paragraph}>
          Are you sure you want to delete the &quot;
          {note?.name}
          &quot; note?
        </p>
        <p className={styles.paragraph}>
          It will be impossible to undo this action.
        </p>
        <div className={styles.buttons}>
          <Button className={styles.button} color="error" size="small" type="submit">Delete</Button>
          <Button className={styles.button} color="primary" size="small" type="button" onClick={handleCloseClick}>Cancel</Button>
        </div>
      </form>
    </Popup>
  );
};
