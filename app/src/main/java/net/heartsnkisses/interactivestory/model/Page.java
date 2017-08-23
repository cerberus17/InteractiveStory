package net.heartsnkisses.interactivestory.model;

/**
 * Created by akipnis on 8/2/2017.
 */

public class Page {
  private int imageId;
  private int storyTextId;
  private Choice firstChoice;
  private Choice secondChoice;
  private boolean isFinalPage = false;

  public Page(int imageId, int storyTextId) {
    this.imageId = imageId;
    this.storyTextId = storyTextId;
    isFinalPage = true;
  }

  public Page(int imageId, int storyTextId, Choice firstChoice, Choice secondChoice) {
    this.imageId = imageId;
    this.storyTextId = storyTextId;
    this.firstChoice = firstChoice;
    this.secondChoice = secondChoice;
  }

  public int getImageId() {
    return imageId;
  }

  public void setImageId(int imageId) {
    this.imageId = imageId;
  }

  public int getStoryTextId() {
    return storyTextId;
  }

  public void setStoryTextId(int storyTextId) {
    this.storyTextId = storyTextId;
  }

  public Choice getFirstChoice() {
    return firstChoice;
  }

  public void setFirstChoice(Choice firstChoice) {
    this.firstChoice = firstChoice;
  }

  public Choice getSecondChoice() {
    return secondChoice;
  }

  public void setSecondChoice(Choice secondChoice) {
    this.secondChoice = secondChoice;
  }

  public boolean isFinalPage() {
    return isFinalPage;
  }
}
