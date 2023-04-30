import React, { FC } from 'react';

import { Logo } from 'components/Logo/Logo';
import { Button } from 'components/Button/Button';
import { List } from 'components/List/List';
import { TextButton } from 'components/TextButton/TextButton';

import { useNavigate } from 'react-router-dom';
import styles from './Header.module.scss';

export const Header: FC = () => {
  const navigate = useNavigate();

  return (
    <header className={styles.header}>
      <Logo />
      <List listStyles={styles.buttons}>
        <Button type="button" onClick={() => navigate('/login')}>Login</Button>
        <TextButton>Register</TextButton>
      </List>
    </header>
  );
};
