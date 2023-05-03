import React, { FC, useEffect } from 'react';
import { $convertFromMarkdownString } from '@lexical/markdown';
import { useLexicalComposerContext } from '@lexical/react/LexicalComposerContext';
import { PLAYGROUND_TRANSFORMERS } from './MarkdownTransformers';

interface ControlledEditorPluginProps {
  content?: string,
}

export const ControlledEditorPlugin: FC<ControlledEditorPluginProps> = ({ content }): null => {
  const [editor] = useLexicalComposerContext();

  useEffect(() => {
    if (content) {
      editor.update(() => {
        $convertFromMarkdownString(content, PLAYGROUND_TRANSFORMERS);
      });
    }
  }, [content]);

  return null;
};
