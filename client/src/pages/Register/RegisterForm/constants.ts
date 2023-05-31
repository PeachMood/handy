export const validationOptions = {
  username: {
    required: 'Please enter username.',
  },
  email: {
    required: 'Please enter email.',
    pattern: {
      value: /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|.(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/,
      message: 'Please enter a valid email.',
    },
  },
  password: {
    required: 'Please enter password.',
    minLength: {
      value: 8,
      message: 'Password must be at least 8 characters long.',
    },
    validate: {
      containsDigit: (password: string) => /\d/.test(password) || 'Password must have at least one digit.',
      containsLowercaseCharacter: (password: string) => /[a-z]/.test(password) || 'Password must have at least one lowercase character.',
      containsUppercaseCharacter: (password: string) => /[A-Z]/.test(password) || 'Password must have at least one uppercase character.',
      containsSpecialCharacter: (password: string) => /\W/.test(password) || 'Password must have at least one special character.',
    },
  },
};
