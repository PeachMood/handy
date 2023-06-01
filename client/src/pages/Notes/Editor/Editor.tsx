import React, { FC } from 'react';
import classNames from 'classnames';
import { EditorState } from 'lexical';
import { LexicalComposer } from '@lexical/react/LexicalComposer';
import { ContentEditable } from '@lexical/react/LexicalContentEditable';
import { RichTextPlugin } from '@lexical/react/LexicalRichTextPlugin';
import { ListPlugin } from '@lexical/react/LexicalListPlugin';
import { LinkPlugin } from '@lexical/react/LexicalLinkPlugin';
import { MarkdownShortcutPlugin } from '@lexical/react/LexicalMarkdownShortcutPlugin';
import { OnChangePlugin } from '@lexical/react/LexicalOnChangePlugin';
import { $convertToMarkdownString, TRANSFORMERS } from '@lexical/markdown';
import LexicalErrorBoundary from '@lexical/react/LexicalErrorBoundary';
import LexicalClickableLinkPlugin from '@lexical/react/LexicalClickableLinkPlugin';

import { initialConfig } from './config/initialConfig';
import { ControlledEditorPlugin } from './plugins/ControlledEditorPlugin';

import styles from './Editor.module.scss';

interface EditorProps {
  content?: string,
  className?: string;
  onChange?: (content: string) => void;
}

const Placeholder = () => (
  <p className={styles.placeholder}>Your note begins here...</p>
);

export const Editor: FC<EditorProps> = ({ content, className, onChange }) => {
  const handleContentChange = (editorState: EditorState) => {
    editorState.read(() => {
      const markdown = $convertToMarkdownString(TRANSFORMERS);
      onChange(markdown);
    });
  };

  return (
    <LexicalComposer initialConfig={initialConfig}>
      <div className={classNames(styles.editor, className)}>
        <ListPlugin />
        <LinkPlugin />
        <LexicalClickableLinkPlugin />
        {onChange && <OnChangePlugin onChange={handleContentChange} />}
        <MarkdownShortcutPlugin transformers={TRANSFORMERS} />
        <ControlledEditorPlugin content={content} />
        <RichTextPlugin
          contentEditable={<ContentEditable spellCheck={false} />}
          placeholder={<Placeholder />}
          ErrorBoundary={LexicalErrorBoundary}
        />
      </div>
    </LexicalComposer>
  );
};
