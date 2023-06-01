import React, { FC } from 'react';

import { List } from 'components/List/List';

import styles from './ButtonsList.module.scss';

export const ButtonsList: FC = ({ children }) => (
  <List listStyles={styles.buttons}>
    {children}
  </List>
);
