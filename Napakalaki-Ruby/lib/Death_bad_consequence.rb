# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

class DeathBadConsequence < NumericBadConsequence
  
  def initialize(aText)
    super(aText,10, @@MAXTREASURES, @@MAXTREASURES)
  end
end