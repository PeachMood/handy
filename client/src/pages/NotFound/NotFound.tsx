import React from 'react';
import { useNavigate } from 'react-router-dom';

import { TextButton } from 'components/TextButton/TextButton';
import { useAuthContext } from 'hooks/context/useAuthContext';

import styles from './NotFound.module.scss';
import { images } from './constants';

export const NotFound = () => {
  const { isLoggedIn } = useAuthContext();
  const navigate = useNavigate();

  const randomImage = images[Math.floor(Math.random() * images.length)];

  const handleGoBackClick = () => {
    navigate(isLoggedIn ? '/notes' : '/', { replace: true });
  };

  return (
    <div className={styles.page}>
      <article className={styles.content}>
        <h1 className={styles.title}>404 Page Not Found</h1>
        <p className={styles.subtitle}>
          The page you’re looking for no longer exists.
          <TextButton size="huge" color="accent" onClick={handleGoBackClick} type="button">
            &#8592; Go back to
            {' '}
            {isLoggedIn ? 'notes' : 'home page'}
          </TextButton>
        </p>
        <figure className={styles.figure}>
          <img className={styles.image} src={randomImage.src} alt={randomImage.alt} />
          <figcaption className={styles.figcaption}>{randomImage.alt}</figcaption>
        </figure>
      </article>
    </div>
  );
};
