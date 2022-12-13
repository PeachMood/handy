import { Button } from 'components/Button/Button';
import React from 'react';

import styles from './Section.module.scss';

export const Section = (): JSX.Element => (
  <section className={styles.section}>
    <h2 className={styles.title}>And it’s absolutely free.</h2>
    <Button color="accent" size="huge" type="button">Register</Button>
  </section>
);
