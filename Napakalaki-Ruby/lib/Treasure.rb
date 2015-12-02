# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
module NapakalakiGame
  
class Treasure
  def initialize( n, bonus1, t)
    @name=n
    @bonus=bonus1
    @type=t
  end
    
    attr_reader:name
    attr_reader:bonus
    attr_reader:type    
    
  def to_s
  "#{@name}. Tipo #{@type}"
  end
    
end

end