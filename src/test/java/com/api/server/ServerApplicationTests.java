package com.api.server;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import com.api.server.entities.MusicEntityTest;
import com.api.server.entity.Music;
import com.api.server.repository.MusicRepository;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class ServerApplicationTests {

	@Autowired
	MusicRepository musicRepository;

	@Autowired
	MusicEntityTest musicEntityTest;

	@Test
	@Order(1)
	public void testCreate() {
		Music music = new Music();
		music.setEmail("test@gmail.com");
		music.setType("Rock");
		music = musicRepository.save(music);
		musicEntityTest.setEmail(music.getEmail());
		assertNotNull(musicRepository.findByEmail(music.getEmail()));
	}

	@Test
	@Order(2)
	public void testReadAll() {
		List<Music> list = musicRepository.findAll();
		assertThat(list).size().isGreaterThan(0);
	}

	@Test
	@Order(3)
	public void testRead() {
		System.out.println("Music Entity Test Email: " + musicEntityTest.getEmail());
		Music music = musicRepository.findByEmail(musicEntityTest.getEmail());
		assertEquals("test@gmail.com", music.getEmail());
	}

	@Test
	@Order(4)
	public void testUpdate() {
		Music music = musicRepository.findByEmail(musicEntityTest.getEmail());
		music.setType("Pop");
		musicRepository.save(music);
		assertNotEquals("Rock", musicRepository.findByEmail(musicEntityTest.getEmail()).getType());
	}

	@Test
	@Order(5)
	public void testDelete() {
		Music musicToBeDeleted = musicRepository.findByEmail(musicEntityTest.getEmail());
		musicRepository.delete(musicToBeDeleted);
		assertThat(musicRepository.existsByEmail(musicEntityTest.getEmail())).isFalse();
	}

}
