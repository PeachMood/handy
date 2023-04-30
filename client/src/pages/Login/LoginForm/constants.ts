export const validationOptions = {
  username: {
    required: 'Please enter username or email.',
    pattern: {
      value: /^(?:\w+|\w+([+.-]?\w+)*@\w+([.-]?\w+)*(\.[a-zA-z]{2,4})+)$/gm,
      message: 'Please enter a valid username or email.',
    },
  },
  password: {
    required: 'Please enter password.',
  },
};
