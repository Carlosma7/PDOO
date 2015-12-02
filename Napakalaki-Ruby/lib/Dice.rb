# Author: Carlos
module NapakalakiGame
  
require "singleton"

class Dice
  
  include Singleton
    
  def nextNumber
     n= rand(6)+1 #Entre 1 y 6
     return n
  end
end

end