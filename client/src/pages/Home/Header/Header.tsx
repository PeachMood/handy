import React from 'react';

import { Logo } from 'components/Logo/Logo';
import { Button } from 'components/Button/Button';
import { List } from 'components/List/List';
import { TextButton } from 'components/TextButton/TextButton';

import styles from './Header.module.scss';

export const Header = () => (
  <header className={styles.header}>
    <Logo />
    <List listStyles={styles.buttons}>
      <Button type="button">Login</Button>
      <TextButton>Register</TextButton>
    </List>
  </header>
);
