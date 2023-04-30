import React, { FC } from 'react';

import { LoginForm } from './LoginForm/LoginForm';

import styles from './Login.module.scss';

export const Login: FC = () => (
  <div className={styles.page}>
    <LoginForm />
  </div>
);
