import { Path, RegisterOptions } from 'react-hook-form';

declare global {
  interface Image {
    src: string;
    alt: string;
  }

  interface Styleable {
    className?: string
  }

  type FormOptions<T> = Partial<Record<keyof T, RegisterOptions<T, Path<T>>>>;
}
