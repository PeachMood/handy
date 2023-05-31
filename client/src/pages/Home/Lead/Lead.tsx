import React, { FC } from 'react';
import { useNavigate } from 'react-router-dom';

import { Button } from 'components/Button/Button';

import creationOfAdam from 'assets/images/creationOfAdam.png';
import styles from './Lead.module.scss';

export const Lead: FC = () => {
  const navigate = useNavigate();

  return (
    <section className={styles.lead}>
      <h1 className={styles.title}>
        Let your&nbsp;
        <span className={styles.accent}>notes</span>
        &nbsp;become art
      </h1>
      <p className={styles.subtitle}>
        Create notes for any tasks and on any devices together with Handy
      </p>
      <Button color="accent" size="large" className={styles.button} type="button" onClick={() => navigate('/register')}>Try now</Button>
      <img className={styles.image} src={creationOfAdam} alt="Michelangelo. The creation of Adam" />
    </section>
  );
};
