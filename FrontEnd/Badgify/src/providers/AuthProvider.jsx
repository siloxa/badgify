import AuthContext from '../contexts/AuthContext';

const AuthProvider = ({ children }) => {
  const AutuToken = localStorage.getItem('token');
  // login , logout
  console.log('a', token);
  const value = { token: AutuToken };
  return <AuthContext.Provider value={value}>{children}</AuthContext.Provider>;
};
export default AuthProvider;
