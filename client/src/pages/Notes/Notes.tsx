import React, { FC } from 'react';

import { Editor } from 'components/Editor/Editor';
import styles from './Notes.module.scss';

export const Notes: FC = () => (
  <div className={styles.page}>
    <Editor />
  </div>
);
