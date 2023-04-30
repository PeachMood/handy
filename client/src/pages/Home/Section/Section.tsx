import React, { FC } from 'react';

import { Button } from 'components/Button/Button';

import styles from './Section.module.scss';

export const Section: FC = () => (
  <section className={styles.section}>
    <h2 className={styles.title}>And it’s absolutely free.</h2>
    <Button color="accent" size="huge" type="button">Register</Button>
  </section>
);
