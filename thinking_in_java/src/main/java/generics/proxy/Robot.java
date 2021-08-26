package generics.proxy;

class Robot implements Performs {
  @Override
  public void speak() { System.out.println("Click!"); }
  @Override
  public void sit() { System.out.println("Clank!"); }
  public void oilChange() {}
}