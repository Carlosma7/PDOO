# Author: Carlos

require "singleton"

class Dice
  
  include Singleton
    
  def public nextNumber
     n= rand(7)
     return n
  end
end
