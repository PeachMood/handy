import React from 'react';

import { Header } from './Header/Header';
import { Lead } from './Lead/Lead';
import { Articles } from './Articles/Articles';
import { Section } from './Section/Section';
import { Footer } from './Footer/Footer';

import styles from './Home.module.scss';

export const Home = () => (
  <div className={styles.page}>
    <div className={styles.content}>
      <Header />
      <main>
        <Lead />
        <Articles />
        <Section />
      </main>
      <Footer />
    </div>
  </div>
);
