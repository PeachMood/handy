import React, { FC } from 'react';

import styles from './SuccessPopup.module.scss';

export const SuccessPopup: FC<{ email: string }> = ({ email }) => (
  <section className={styles.popup}>
    <div className={styles.icon} aria-label="success icon" />
    <h1 className={styles.title}>Check your email</h1>
    <p className={styles.subtitle}>
      To the address
      {' '}
      <span className={styles.accent}>{email}</span>
      {' '}
      we have sent you an email.
      Click on the link in it to complete the registration.
    </p>
  </section>
);
