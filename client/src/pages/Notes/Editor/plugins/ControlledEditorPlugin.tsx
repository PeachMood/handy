import React, { FC, useEffect } from 'react';
import { $convertFromMarkdownString, TRANSFORMERS } from '@lexical/markdown';
import { useLexicalComposerContext } from '@lexical/react/LexicalComposerContext';
import { $getRoot } from 'lexical';

interface ControlledEditorPluginProps {
  content?: string,
}

export const ControlledEditorPlugin: FC<ControlledEditorPluginProps> = ({ content }): null => {
  const [editor] = useLexicalComposerContext();

  useEffect(() => {
    if (content !== null && content !== undefined) {
      editor.update(() => {
        $convertFromMarkdownString(content, TRANSFORMERS);
      });
    }
  }, [content]);

  return null;
};
