# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

class Treasure
  def initialize( n, g, bonus1, t)
    @name=n
    @bonus=bonus1
    @treasure=t
  end
    
    attr_reader:name
    attr_reader:bonus
    attr_reader:treasure    
    
end
