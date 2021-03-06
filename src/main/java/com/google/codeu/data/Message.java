/*
 * Copyright 2019 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.codeu.data;

import java.util.ArrayList;
import java.util.UUID;

/** A single message posted by a user. */
public class Message {

  private UUID id;
  private String user; // author of message
  private String text;
  private long timestamp;
  private String country;
  private String category;
  private String lat;
  private String lng;
  private String imageUrl;
  private ArrayList<String> replies;

  /**
   * Constructs a new {@link Message} posted by {@code user} to {@code country} with {@code text}
   * content. Generates a random ID and uses the current system time for the creation time.
   */
  public Message(
      String user, String text, String country, String category, String lat, String lng) {
    this(UUID.randomUUID(), user, text, System.currentTimeMillis(), country, category, lat, lng);
  }

  // Constructor for edited messages which already have an ID, update timestamp
  public Message(
      String idStr,
      String user,
      String text,
      String country,
      String category,
      String lat,
      String lng) {
    this(
        UUID.fromString(idStr),
        user,
        text,
        System.currentTimeMillis(),
        country,
        category,
        lat,
        lng);
  }

  public Message(
      UUID id,
      String user,
      String text,
      long timestamp,
      String country,
      String category,
      String lat,
      String lng) {
    this.id = id;
    this.user = user;
    this.text = text;
    this.timestamp = timestamp;
    this.country = country;
    this.category = category;
    this.lat = lat;
    this.lng = lng;
    this.imageUrl = "";
    this.replies = new ArrayList<>();
  }

  public String getCountry() {
    return country;
  }

  public String getCategory() {
    return category;
  }

  public UUID getId() {
    return id;
  }

  public String getUser() {
    return user;
  }

  public String getText() {
    return text;
  }

  public long getTimestamp() {
    return timestamp;
  }

  public String getLat() {
    return lat;
  }

  public String getLng() {
    return lng;
  }

  public ArrayList<String> getReplies() {
    return replies;
  }

  public void addReply(String reply) {
    replies.add(reply);
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String newImageUrl) {
    imageUrl = newImageUrl;
  }

  public boolean hasAnImage() {
    if (this.imageUrl == null || this.imageUrl.isEmpty()) {
      return false;
    } else {
      return true;
    }
  }

  public boolean hasALocation() {
    if (this.lat.isEmpty() && this.lng.isEmpty()) {
      return false;
    } else {
      return true;
    }
  }
}
