package com.inti.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.inti.repository.IPersonneRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	IPersonneRepository ipr;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Personne p = ipr.findByLogin(username);
		if(p==null)
		{
			throw new UsernameNotFoundException("Le login : " + username + " n'existe pas en BDD");
		}
		return User.withUsername(p.getLogin())
				.password(p.getMdp())
				.authorities("CLIENT") // => On passe par la fonction hasAuthorities
//				.roles("CLIENT")
				.build();
	}


	
}
