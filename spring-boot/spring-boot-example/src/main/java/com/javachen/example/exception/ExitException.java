package com.javachen.example.exception;

import org.springframework.boot.ExitCodeGenerator;

/**
 * Created by yuke on 16/2/19.
 */
public class ExitException extends RuntimeException implements ExitCodeGenerator {

  @Override
  public int getExitCode() {
    return 10;
  }

}