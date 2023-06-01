import React, { FC } from 'react';

import { Link } from 'components/Link/Link';
import { List } from 'components/List/List';
import { IconButton } from 'components/IconButton/IconButton';

import styles from './Footer.module.scss';
import { socialIcons } from './constants';

export const Footer: FC = () => {
  const handleSocialClick = (href: string) => {
    window.open(href, '_blank');
  };

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
        <List itemStyles={styles.item}>
          {socialIcons.map((icon) => (
            <IconButton
              key={icon.image}
              image={icon.image}
              type="button"
              onClick={() => handleSocialClick(icon.href)}
            />
          ))}
        </List>
      </nav>
    </footer>
  );
};
