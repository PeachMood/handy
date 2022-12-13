import React from 'react';

import { Link } from 'components/Link/Link';
import { List } from 'components/List/List';
import { IconButton } from 'components/IconButton/IconButton';
import { socialIcons } from 'utils/constants';
import { Social } from 'types/types';

import styles from './Footer.module.scss';

export const Footer = () => {
  const rederIcon = (icon: Social): JSX.Element => <IconButton key={icon.image.alt} image={icon.image} href={icon.href} target="_blank" />;

  return (
    <footer className={styles.footer}>
      <div>
        <h3 className={styles.title}>Contact us:</h3>
        <Link
          color="accent"
          size="large"
          href="mailto: handy@gmail.com"
          target="_blank"
        >
          handy@gmail.com
        </Link>
      </div>
      <nav>
        <h3 className={styles.title}>Follow us:</h3>
        <List itemStyles={styles.icon}>{socialIcons.map(rederIcon)}</List>
      </nav>
    </footer>
  );
};
