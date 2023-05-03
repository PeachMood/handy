import { HeadingNode, QuoteNode } from '@lexical/rich-text';
import { ListNode, ListItemNode } from '@lexical/list';
import { LinkNode, AutoLinkNode } from '@lexical/link';
import { CodeNode } from '@lexical/code';
import { InitialConfigType } from '@lexical/react/LexicalComposer';

import styles from '../Editor.module.scss';

export const initialConfig: InitialConfigType = {
  namespace: 'notes-editor',
  theme: {
    root: styles.content,
    paragraph: styles.paragraph,
    heading: {
      h1: styles.h1,
      h2: styles.h2,
      h3: styles.h3,
      h4: styles.h4,
      h5: styles.h5,
      h6: styles.h6,
    },
    quote: styles.quote,
    list: {
      listitem: styles.listitem,
    },
    link: styles.link,
  },
  nodes: [
    HeadingNode,
    QuoteNode,
    ListNode,
    ListItemNode,
    LinkNode,
    AutoLinkNode,
    CodeNode,
  ],
  onError: (error: Error) => console.log(error),
};
