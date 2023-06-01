import React, { FC } from 'react';
import classNames from 'classnames';

import { List } from 'components/List/List';
import { IconButton } from 'components/IconButton/IconButton';

import profileIcon from 'assets/images/profileIcon.svg';
import helpIcon from 'assets/images/helpIcon.svg';
import settingsIcon from 'assets/images/settingsIcon.svg';
import styles from './Userbar.module.scss';

export const Userbar: FC<Styleable> = ({ className }) => (
  <section className={classNames(styles.panel, className)}>
    <List listStyles={styles.list}>
      <IconButton image={profileIcon} />
      <IconButton image={helpIcon} />
      <IconButton image={settingsIcon} />
    </List>
  </section>
);
