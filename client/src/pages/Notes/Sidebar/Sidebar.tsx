import React from 'react';
import classNames from 'classnames';

import { useSidebarContext } from 'hooks/context/useSidebarContext';

import { ContentFactory } from './content/ContentFactory';
import { Navbar } from './layout/Navbar/Navbar';
import { Userbar } from './layout/Userbar/Userbar';
import { Content } from './layout/Content/Content';

import styles from './Sidebar.module.scss';

export const Sidebar = () => {
  const { isOpened, content } = useSidebarContext();
  const sidebarStyles = classNames(styles.sidebar, { [styles.opened]: isOpened });

  return (
    <aside className={sidebarStyles}>
      <Navbar />
      <Userbar />
      <Content>
        <ContentFactory content={content} />
      </Content>
    </aside>
  );
};
