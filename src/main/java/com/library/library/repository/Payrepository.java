package com.library.library.repository;

import com.library.library.model.Pay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Payrepository extends JpaRepository<Pay,Long> {
}
