import React, { FC } from 'react';
import classNames from 'classnames';

import { List } from 'components/List/List';
import { IconButton } from 'components/IconButton/IconButton';
import { Content } from 'contexts/SidebarContext';
import { useSidebarContext } from 'hooks/context/useSidebarContext';

import sidebarOpenedIcon from 'assets/images/sidebarOpenedIcon.svg';
import sidebarClosedIcon from 'assets/images/sidebarClosedIcon.svg';
import folderIcon from 'assets/images/folderIcon.svg';
import searchIcon from 'assets/images/searchIcon.svg';
import starIcon from 'assets/images/starIcon.svg';
import styles from './Navbar.module.scss';

export const Navbar: FC = () => {
  const { isOpened, setIsOpened, setContent } = useSidebarContext();
  const sidebarIcon = isOpened ? sidebarOpenedIcon : sidebarClosedIcon;
  const buttonStyles = classNames(styles.button, { [styles.hidden]: !isOpened });

  const handleToggleClick = () => {
    setIsOpened(((state) => !state));
  };

  const handleNotesClick = () => {
    setContent(Content.Notes);
  };

  const handleSearchClick = () => {
    setContent(Content.Search);
  };

  const handleFavouritesClick = () => {
    setContent(Content.Favourites);
  };

  return (
    <nav className={styles.navbar}>
      <List listStyles={styles.buttons}>
        <IconButton image={sidebarIcon} onClick={handleToggleClick} />
        <IconButton className={buttonStyles} image={folderIcon} onClick={handleNotesClick} />
        <IconButton className={buttonStyles} image={searchIcon} onClick={handleSearchClick} />
        <IconButton className={buttonStyles} image={starIcon} onClick={handleFavouritesClick} />
      </List>
    </nav>
  );
};
