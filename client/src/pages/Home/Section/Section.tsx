import React, { FC } from 'react';
import { useNavigate } from 'react-router-dom';

import { Button } from 'components/Button/Button';

import styles from './Section.module.scss';

export const Section: FC = () => {
  const navigate = useNavigate();

  return (
    <section className={styles.section}>
      <h2 className={styles.title}>And it’s absolutely free.</h2>
      <Button color="accent" size="huge" type="button" onClick={() => navigate('/register')}>Register</Button>
    </section>
  );
};
