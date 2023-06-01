import React, { FC } from 'react';
import classNames from 'classnames';

import { useSidebarContext } from 'hooks/context/useSidebarContext';

import styles from './Content.module.scss';

export const Content: FC<Styleable> = ({ className, children }) => {
  const { isOpened } = useSidebarContext();
  const contentStyles = classNames(styles.container, { [styles.hidden]: !isOpened }, className);

  return (
    <section className={contentStyles}>
      {children}
    </section>
  );
};
